package main.java.org.pipelinemc.Pipeline.Connection;

import com.flowpowered.networking.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import org.pipelinemc.Pipeline.Util.TextMessage;
import org.pipelinemc.Pipeline.World.BlockVector;
import org.pipelinemc.Pipeline.World.Vector;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;

public final class PipeBufUtils {

    private PipeBufUtils() {
    }

    public static List<MetadataMap.Entry> readMetadata(ByteBuf buf) throws IOException {
        List<MetadataMap.Entry> entries = new ArrayList<>();
        byte item;
        while ((item = buf.readByte()) != 0x7F) {
            MetadataType type = MetadataType.byId(item >> 5);
            int id = item & 0x1f;
            MetadataIndex index = MetadataIndex.getIndex(id, type);
            switch (type) {
                case BYTE:
                    entries.add(new MetadataMap.Entry(index, buf.readByte()));
                    break;
                case SHORT:
                    entries.add(new MetadataMap.Entry(index, buf.readShort()));
                    break;
                case INT:
                    entries.add(new MetadataMap.Entry(index, buf.readInt()));
                    break;
                case FLOAT:
                    entries.add(new MetadataMap.Entry(index, buf.readFloat()));
                    break;
                case STRING:
                    entries.add(new MetadataMap.Entry(index, ByteBufUtils.readUTF8(buf)));
                    break;
                case ITEM:
                    entries.add(new MetadataMap.Entry(index, readSlot(buf)));
                    break;
            }
        }
        return entries;
    }

    public static void writeMetadata(ByteBuf buf, List<MetadataMap.Entry> entries) throws IOException {
        for (MetadataMap.Entry entry : entries) {
            MetadataIndex index = entry.index;
            Object value = entry.value;

            if (value == null) continue;

            int type = index.getType().getId();
            int id = index.getIndex();
            buf.writeByte((type << 5) | id);

            switch (index.getType()) {
                case BYTE:
                    buf.writeByte((Byte) value);
                    break;
                case SHORT:
                    buf.writeShort((Short) value);
                    break;
                case INT:
                    buf.writeInt((Integer) value);
                    break;
                case FLOAT:
                    buf.writeFloat((Float) value);
                    break;
                case STRING:
                    ByteBufUtils.writeUTF8(buf, (String) value);
                    break;
                case ITEM:
                    writeSlot(buf,  value);
                    break;
            }
        }

        buf.writeByte(127);
    }

    public static CompoundTag readCompound(ByteBuf buf) {
        int idx = buf.readerIndex();
        if (buf.readByte() == 0) {
            return null;
        }

        buf.readerIndex(idx);
        try (NBTInputStream str = new NBTInputStream(new ByteBufInputStream(buf), false)) {
            return str.readCompound();
        } catch (IOException e) {
            return null;
        }
    }

    public static void writeCompound(ByteBuf buf, CompoundTag data) {
        if (data == null) {
            buf.writeByte(0);
            return;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (NBTOutputStream str = new NBTOutputStream(out, false)) {
            str.writeTag(data);
        } catch (IOException e) {
            GlowServer.logger.log(Level.WARNING, "Error serializing NBT: " + data, e);
            return;
        }

        buf.writeBytes(out.toByteArray());
    }

    public static ItemStack readSlot(ByteBuf buf) {
        short type = buf.readShort();
        if (type == -1) {
            return null;
        }

        int amount = buf.readUnsignedByte();
        short durability = buf.readShort();

        Material material = Material.getMaterial(type);
        if (material == null) {
            return null;
        }

        CompoundTag tag = readCompound(buf);
        ItemStack stack = new ItemStack(material, amount, durability);
        stack.setItemMeta(GlowItemFactory.instance().readNbt(material, tag));
        return stack;
    }


    public static void writeSlot(ByteBuf buf, ItemStack stack) {
        if (stack == null || stack.getTypeId() == 0) {
            buf.writeShort(-1);
        } else {
            buf.writeShort(stack.getTypeId());
            buf.writeByte(stack.getAmount());
            buf.writeShort(stack.getDurability());

            if (stack.hasItemMeta()) {
                CompoundTag tag = GlowItemFactory.instance().writeNbt(stack.getItemMeta());
                writeCompound(buf, tag);
            } else {
                writeCompound(buf, null);
            }
        }
    }

    public static Vector readBlockPosition(ByteBuf buf) {
        long val = buf.readLong();
        long x = (val >> 38);
        long y = (val >> 26) & 0xfff;
        long z = (val << 38) >> 38;
        return new Vector((double) x, y, z);
    }

    public static void writeBlockPosition(ByteBuf buf, BlockVector vector) {
        writeBlockPosition(buf, vector.getX(), vector.getY(), vector.getZ());
    }

    public static void writeBlockPosition(ByteBuf buf, long x, long y, long z) {
        buf.writeLong(((x & 0x3ffffff) << 38) | ((y & 0xfff) << 26) | (z & 0x3ffffff));
    }

    public static UUID readUuid(ByteBuf buf) {
        return new UUID(buf.readLong(), buf.readLong());
    }

    public static void writeUuid(ByteBuf buf, UUID uuid) {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());
    }

    public static TextMessage readChat(ByteBuf buf) throws IOException {
        return TextMessage.decode(ByteBufUtils.readUTF8(buf));
    }

    public static void writeChat(ByteBuf buf, TextMessage text) throws IOException {
        ByteBufUtils.writeUTF8(buf, text.encode());
    }

}
