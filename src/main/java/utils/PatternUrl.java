package utils;

public class PatternUrl{
    private static String home = "home";
    private static String product = "product";
    private static String customer = "customer";
    private static String user = "user";
    private static String category = "category";
    private static String provider = "provider";
    private static String storeSpace = "store";

    // components
    private static String list= "list";
    private static String frm= "frm";

    private static String abstractURI = "abstract";

    public static String getHome() {
        return home;
    }

    public void setHome(String home) {
        home = home;
    }

    public static String getProduct() {
        return product;
    }

    public static void setProduct(String product) {
        product = product;
    }

    public static String getCustomer() {
        return customer;
    }

    public static void setCustomer(String customer) {
        customer = customer;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        user = user;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        category = category;
    }

    public static String getProvider() {
        return provider;
    }

    public static void setProvider(String provider) {
        provider = provider;
    }

    public static String getStoreSpace() {
        return storeSpace;
    }

    public static void setStoreSpace(String storeSpace) {
        storeSpace = storeSpace;
    }

    public static String getList() {
        return list;
    }

    public static void setList(String list) {
        list = list;
    }

    public static String getFrm() {
        return frm;
    }

    public static void setFrm(String frm) {
        frm = frm;
    }

    public static String getAbstractURI() {
        return abstractURI;
    }

    public static void setAbstractURI(String abstractURI) {
        abstractURI = abstractURI;
    }

    public static String getHomeRoute(String route)
    {
        return home +"/"+ route;
    }

    public static String getListRoute(String route)
    {
        return getHomeRoute(list) + "/" + route;
    }


    public static String getRest(String finalName)
    {
        return finalName;
    }

    public static String getRest(Class clazz)
    {
        String name = clazz.getSimpleName().toLowerCase();
        return getRest(name);
    }
}
