import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        String whereClause = formWhereClause(jsonString);
        System.out.println("WHERE clause: " + whereClause);
    }

    private static String formWhereClause(String jsonString) {
        StringBuilder whereClause = new StringBuilder();
        JSONObject jsonObject = new JSONObject(jsonString);

        for (String key : jsonObject.keySet()) {
            String value = jsonObject.getString(key);
            if (!"null".equals(value)) {
                if (whereClause.length() > 0) {
                    whereClause.append(" and ");
                }
                whereClause.append(key).append("=").append("'").append(value).append("'");
            }
        }

        return whereClause.toString();
    }
}
