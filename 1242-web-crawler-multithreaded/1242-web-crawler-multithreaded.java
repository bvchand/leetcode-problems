/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    Set<String> crawledUrls = new HashSet<>();
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Stream<String> result = processUrl(startUrl, htmlParser, getHostName(startUrl));
        return result.collect(Collectors.toList());
    }
    
    public Stream<String> processUrl(String currUrl, HtmlParser htmlParser, String hostName) {
        if(!crawledUrls.add(currUrl) || !Objects.equals(hostName, getHostName(currUrl)))
            return Stream.empty();
        
        List<String> urls = htmlParser.getUrls(currUrl);
        
        return Stream.concat(Stream.of(currUrl), urls.parallelStream().flatMap(next -> processUrl(next, htmlParser, hostName)));
    }
    
    public String getHostName(String url) {
        String domain = url.split("http://")[1];
        return domain.split("/")[0];
    }
}