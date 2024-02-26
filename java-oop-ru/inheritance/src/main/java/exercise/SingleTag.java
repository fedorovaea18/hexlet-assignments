package exercise;

import java.util.Map;

public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append(">");
        return sb.toString();
    }
}

