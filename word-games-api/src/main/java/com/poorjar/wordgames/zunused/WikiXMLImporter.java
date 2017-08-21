package com.poorjar.wordgames.zunused;

/**
 * Created by swaroop on 8/19/17.
 */
public class WikiXMLImporter {
//        URL url = new URL("https://en.wikipedia.org/wiki/Special:Export/List_of_Telugu_films_of_2001");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        int responseCode = connection.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//
//        // Init Output File
//        initOutputFile();
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String inputLine;
//
//        FileWriter writer = new FileWriter("output.xml");
//
//        try {
//            while ((inputLine = in.readLine()) != null) {
//                writer.write(inputLine);
//            }
//        } finally {
//            IOUtils.closeQuietly(in);
//            IOUtils.closeQuietly(writer);
//        }


//        File file = new File("output.xml");
//
//        XmlMapper mapper = new XmlMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
//        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, Boolean.FALSE);
//        WikiPage wikipage = mapper.readValue(file, WikiPage.class);
//        System.out.println(wikipage.toString());
}

//
//    private static void initOutputFile() throws Exception {
//        FileWriter writer = new FileWriter("output.xml");
//        writer.write("");
//        writer.close();
//    }
//
//
//    private static void writeWikiTableToFile(Elements table) throws Exception {
//        initOutputFile();
//
//        for (Element element : table) {
//            System.out.println(element.html());
//        }
//    }
//
//    private static void initOutputFile() throws Exception {
//        FileWriter writer = new FileWriter("output.xml");
//        writer.write("");
//        writer.close();
//    }
//
//@JacksonXmlRootElement(localName = "tbody")
//class WikiTable {
//    @JacksonXmlProperty(localName = "tr")
//    @JacksonXmlElementWrapper(useWrapping = false)
//    private TR[] trs;
//
//    public TR[] getTRs() {
//        return trs;
//    }
//
//    public void setTRs(TR[] trs) {
//        this.trs = trs;
//    }
//}
//
//
//class TR {
//    @JacksonXmlProperty(localName = "td")
//    @JacksonXmlElementWrapper(useWrapping = false)
//    private TD[] tds;
//
//    public TD[] getTDs() {
//        return tds;
//    }
//
//    public void setTDs(TD[] tds) {
//        this.tds = tds;
//    }
//}
//
//class TD {
//    @JacksonXmlText
//    private String td;
//
//    @JacksonXmlProperty(localName = "i")
//    @JacksonXmlElementWrapper(useWrapping = false)
//    private IElement i;
//
//    @JacksonXmlProperty(localName = "a")
//    @JacksonXmlElementWrapper(useWrapping = false)
//    private AElement a;
//
//    public String getTd() {
//        return td;
//    }
//
//    public void setTd(String td) {
//        this.td = td;
//    }
//
//    public IElement getI() {
//        return i;
//    }
//
//    public void setI(IElement i) {
//        this.i = i;
//    }
//
//    public AElement getA() {
//        return a;
//    }
//
//    public void setA(AElement a) {
//        this.a = a;
//    }
//}
//
//class IElement {
//    @JacksonXmlText
//    private AElement i;
//
//    public AElement getI() {
//        return i;
//    }
//
//    public void setI(AElement i) {
//        this.i = i;
//    }
//}
//
//
//class AElement {
//    @JacksonXmlText
//    private String a;
//
//    public String getA() {
//        return a;
//    }
//
//    public void setA(String a) {
//        this.a = a;
//    }
//}
//
//    private static void parseXML() throws Exception {
//        File file = new File("output.xml");
//
//        XmlMapper mapper = new XmlMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
//        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, Boolean.FALSE);
//        //mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        WikiTable table = mapper.readValue(file, WikiTable.class);
//
//        for (TR tr : table.getTRs()) {
//            for (TD td : tr.getTDs()) {
//                System.out.println(td.getTd());
//            }
//        }
//    }
