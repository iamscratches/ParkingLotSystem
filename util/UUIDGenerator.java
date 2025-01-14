package util;

import java.util.UUID;

public class UUIDGenerator {
    public int generateIntegerUUID() {

        UUID uuid = UUID.randomUUID();
        return Math.abs(uuid.hashCode());
    }
    public String generateStringUUID(){
        return UUID.randomUUID().toString();
    }
}
