package exercise;

import java.util.Map;
import java.util.List;

public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tagName);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append(">");

        sb.append(body);

        for (Tag child : children) {
            sb.append(child.toString());
        }

        sb.append("</").append(tagName).append(">");
        return sb.toString();
    }
}

