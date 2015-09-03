package main.java.org.pipelinemc.Pipeline.Connection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by JessiePeek on 9/3/2015.
 */
public class ProxyData {

        private final String hostname;
        private final InetSocketAddress address;
        private final UUID uuid;
        private final List<Object> properties;

        public ProxyData(GlowSession session, String sourceText) throws Exception {
            String[] parts = sourceText.split("\0");
            if (parts.length != 3 && parts.length != 4) {
                throw new IllegalArgumentException("parts length was " + parts.length + ", should be 3 or 4");
            }

            hostname = parts[0];
            address = new InetSocketAddress(parts[1], session.getAddress().getPort());
            uuid = UUID.fromString(parts[2]);

            if (parts.length == 4) {
                JSONArray jsonProperties = (JSONArray) new JSONParser().parse(parts[3]);

                properties = new ArrayList<Object>(jsonProperties.size());
                for (Object obj : jsonProperties) {
                    JSONObject propJson = (JSONObject) obj;
                    String propName = (String) propJson.get("name");
                    String value = (String) propJson.get("value");
                    String signature = (String) propJson.get("signature");
                }
            } else {
                properties = new ArrayList<Object>(0);
            }
        }


        public String getHostname() {
            return hostname;
        }

        public InetSocketAddress getAddress() {
            return address;
        }
}
