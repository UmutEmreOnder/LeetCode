public class Codec {
    // Map is for storing the urls in longUrl (key) -> shortUrl (value) format
    // Set is to prevent shortUrls from being the same
    public Map<String, String> longToShort = new HashMap<>();
    public Set<String> shorts = new HashSet<>();



    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)) return longToShort.get(longUrl);

        int length = shorts.size();
        String generatedString = "";

        // The purpose of this loop is to prevent the generated random string from being equal to a generated random string before.
        // Note: Question can be solved without this loop, but it is more realistic
        do {
            generatedString = generateRandom();
            shorts.add(generatedString);
        } while(length == shorts.size());


        // Adding the prefix
        String shortUrl = "http://tinyurl.com/" + generatedString;
        longToShort.put(longUrl, shortUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return getKey(longToShort, shortUrl);
    }


    // Getting the key from the value on a hashMap
    public String getKey(Map<String, String> map, String value) {
        for (String key: map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }

        return null;
    }

    // Generate alphanumeric random string with 6 length
    public String generateRandom() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}