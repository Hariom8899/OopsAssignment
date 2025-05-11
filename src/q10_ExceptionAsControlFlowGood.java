public class q10_ExceptionAsControlFlowGood {
    public static void main(String[] args) {
        String[] data = {"apple", "banana", "stop", "cherry"};

        for (String item : data) {
            System.out.println("Processing: " + item);
            if ("stop".equals(item)) {
                System.out.println("Stop signal received. Exiting loop.");
                break;
            }
        }

        System.out.println("Program continued...");
    }
}

