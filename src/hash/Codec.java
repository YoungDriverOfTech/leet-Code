package hash;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    // https://leetcode-cn.com/problems/encode-and-decode-tinyurl/comments/
    private Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = longUrl.hashCode() + "";
        map.put(hash, longUrl);
        return "http://tinyurl.com/" + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String hash = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        return map.get(hash);
    }
}
