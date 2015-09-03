package org.pipelinemc.Pipeline.blocks;

import org.pipelinemc.Pipeline.World.Block;
import org.pipelinemc.Pipeline.entity.Player;


public interface BlockEventer {
    void BlockUpdate(Block b);

    void GrowthUpdate(Block b);

    void Placed(Block b, Player p);

    MaterialType Broken(Block b, Player p);
}
