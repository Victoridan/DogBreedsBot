package services;

public class MessageHelper {

    public static String formatTitle(String title) {
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            separator.append("=");
        }
        return "🐕 *" + title + "*\n" + separator.toString() + "\n";
    }

    public static String formatSubtitle(String subtitle) {
        return "\n📋 *" + subtitle + "*\n";
    }

    public static String formatInfo(String message) {
        return "💡 " + message;
    }

    public static String formatError(String message) {
        return "❌ " + message;
    }

    public static String formatSuccess(String message) {
        return "✅ " + message;
    }

    public static String formatQuestion(int number, String question) {
        return String.format("%d. %s", number, question);
    }

    public static String formatOption(String option) {
        return "• " + option;
    }

    public static String escapeMarkdown(String text) {
        return text.replace("_", "\\_")
                .replace("*", "\\*")
                .replace("[", "\\[")
                .replace("]", "\\]")
                .replace("(", "\\(")
                .replace(")", "\\)")
                .replace("~", "\\~")
                .replace("`", "\\`")
                .replace(">", "\\>")
                .replace("#", "\\#")
                .replace("+", "\\+")
                .replace("-", "\\-")
                .replace("=", "\\=")
                .replace("|", "\\|")
                .replace("{", "\\{")
                .replace("}", "\\}")
                .replace(".", "\\.")
                .replace("!", "\\!");
    }
}