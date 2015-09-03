 package org.pipelinemc.Pipeline.Connection;

 import com.flowpowered.networking.Message;
 import com.flowpowered.networking.session.BasicSession;
 import io.netty.channel.Channel;
 import org.pipelinemc.Pipeline.Connection.protocol.ProtocolType;

 import java.net.InetSocketAddress;
 import java.util.ArrayDeque;
 import java.util.Queue;
 import java.util.Random;

public final class PipeSession extends BasicSession {
     private static final int TIMEOUT_TICKS = 300;
     private final PipeServer server;
     private final Random random = new Random();
     private final Queue<Message> messageQueue = new ArrayDeque<Message>();
     private InetSocketAddress address;
     private byte[] verifyToken;
     private String verifyUsername;
     private String hostname;
     private int readTimeoutCounter = 0;
     private ProxyData proxyData;
     private int writeTimeoutCounter = 0;
     private int pingMessageId;


     private int previousPlacementTicks;

     public PipeSession(PipeServer server, Channel channel) {
         super(channel, ProtocolType.HANDSHAKE.getProtocol());
         this.server = server;
         address = super.getAddress();
     }

     public PipeServer getServer() {
         return server;
     }

     public byte[] getVerifyToken() {
         return verifyToken;
     }

     public void setVerifyToken(byte[] verifyToken) {
         this.verifyToken = verifyToken;
     }

     public String getVerifyUsername() {
         return verifyUsername;
     }

     public void setVerifyUsername(String verifyUsername) {
         this.verifyUsername = verifyUsername;
     }

     public ProxyData getProxyData() {
         return proxyData;
     }

     public void setProxyData(ProxyData proxyData) {
         this.proxyData = proxyData;
         address = proxyData.getAddress();
         hostname = proxyData.getHostname();
     }

     public void setHostname(String hostname) {
         this.hostname = hostname;
     }

     public void pong(long pingId) {
         if (pingId == pingMessageId) {
             readTimeoutCounter = 0;
             pingMessageId = 0;
         }
     }

     @Override
     public InetSocketAddress getAddress() {
         return address;
     }
 }