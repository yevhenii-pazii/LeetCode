package problem;

public class P2125 {

    /*
        Time Complexity O(N * M) -> array length * row length
        Space Complexity O(1)
     */
    public int numberOfBeams(String[] bank) {
        var previousDevices = 0;
        var beams = 0;

        for (var row : bank) {
            var currentDevices = 0;
            for (var i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    currentDevices++;
                }
            }

            if (currentDevices != 0) {
                beams += previousDevices * currentDevices;
                previousDevices = currentDevices;
            }
        }

        return beams;
    }
}
