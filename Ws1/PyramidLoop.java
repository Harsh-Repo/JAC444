//Workshop#1=========>>>>>>>>>>>>>>>>>>>
//Seneca Id Number: 146315205
///Name: Harsh Patel
//Class: JAC444NAA
//<<<<<<<<<<<<<<<<<<<===================

public class PyramidLoop {
    private static final String string = " ";

    public static void main(String[] strings) {

        int num = 0;
        //Loop for number of rows.
        for (int row =0; row <8; row++) {

            //Loop for columns.
            for (int col = 1; col <= 8 - row; col++) {
                System.out.printf("%4s", string);
            }
            for (int col = 0; col <= row; col++) {
                num = (int) Math.pow(2, col);
                System.out.printf("%4d", num);
            }

            for (int col = row - 1; col >= 0; col--) {
                num = (int) Math.pow(2, col);
                System.out.printf("%4d", num);
            }

            System.out.println();
        }
    }
}