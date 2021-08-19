import java.util.*;

public final class RearrangingCars {

    public static class Move {
        int car;
        char from;
        char to;


        public Move(int car, char from, char to) {
            this.car = car;
            this.from = from;
            this.to = to;
        }

        // We need to be able to compare moves in tests
        @Override
        public boolean equals(Object o) {
            Move other = (Move) o;
            return this.equals(other);
        }
    }

    public static class Parking {
        Map<Integer, Character> carToLotMapping;
        public Parking(Map<Integer, Character> carToLotMapping) {
            this.carToLotMapping = carToLotMapping;

        }

    }

    public static Iterable<Move> rearrangeCars(Parking initialParking, Parking finalParking) {
        ArrayList<Move> moves = new ArrayList<>();

            int [] initialP = new int[initialParking.carToLotMapping.size()+1];

            for (Map.Entry<Integer, Character> mapEntry : initialParking.carToLotMapping.entrySet()) {


                int val = (int) mapEntry.getValue();
                initialP[val-65] = (int) mapEntry.getKey();

            }


        int [] finalP = new int[initialParking.carToLotMapping.size()+1];

            for (Map.Entry<Integer, Character> mapEntry : finalParking.carToLotMapping.entrySet()) {
                int val = (int) mapEntry.getValue();
                finalP[val-65] =   mapEntry.getKey();

            }

            int emptyIndex = 0;
            for (int i = 0;i<initialP.length; i++){
                if ( initialP[i] == 0 ){
                    emptyIndex = i;
                    break;
                }
            }









        for (int f = 0; f<finalP.length ; f++) { //check what's in A


                    if (initialP[f] != 0 && initialP[f] != finalP[f]) {

                        initialP[emptyIndex] = initialP[f];
                        moves.add(new Move(initialP[f], (char) (f + 65), (char) (emptyIndex + 65)));
                        System.out.println("Moved " + initialP[f] + " From: " + (char) (f + 65) + " to: " + (char) (emptyIndex + 65));

                        emptyIndex = f;
                        initialP[f] = 0;


                        for (int i = f; i < initialP.length; i++) {
                            if (initialP[i] == finalP[f] && initialP[f] != finalP[f]) {
                                initialP[f] = initialP[i];
                                moves.add(new Move(initialP[i], (char) (i + 65), (char) (f + 65)));
                                System.out.println("Moved " + initialP[i] + " From: " + (char) (i + 65) + " to: " + (char) (f + 65));

                                emptyIndex = i;
                                initialP[i] = 0;
                                break;

                            }

                        }
                    } else {


                        if (finalP[f] != 0 ) {
                        for (int i = f; i < initialP.length; i++) {
                            if (initialP[i] == finalP[f] && initialP[f] != finalP[f]) {
                                initialP[f] = initialP[i];
                                moves.add(new Move(initialP[i], (char) (i + 65), (char) (f + 65)));
                                System.out.println("Moved " + initialP[i] + " From: " + (char) (i + 65) + " to: " + (char) (f + 65));
                                emptyIndex = i;
                                initialP[i] = 0;
                                break;

                            }

                        }
                        }


                    }
                }
        return moves;
    }


    public static void main(String[] args) {

        Map m1 = new LinkedHashMap();
        m1.put(1,'A');



        Map m2 = new LinkedHashMap();
        m2.put(1,'B');







        Parking P1 = new Parking(m1);
        Parking P2 = new Parking(m2);
        Iterable itr = rearrangeCars(P1, P2);


    }


}