package Sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coordinate size;
    public static ArrayList<Coordinate> allCoodinates;
    private static Random random = new Random();

    static void setSize(Coordinate _size) {
        size = _size;
        allCoodinates = new ArrayList<>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoodinates.add(new Coordinate(x, y));
            }
        }
    }

    public static Coordinate getSize() {
        return size;
    }

    public static ArrayList<Coordinate> getAllCoodinates() {
        return allCoodinates;
    }

    static boolean inRange(Coordinate coordinate) {
        return coordinate.x >= 0 && coordinate.x < size.x &&
                coordinate.y >= 0 && coordinate.y < size.y;
    }

    static Coordinate getRandomCoordinate() {
        return new Coordinate(random.nextInt(size.x), random.nextInt(size.y));
    }

    static ArrayList<Coordinate> getCoordinatesAround(Coordinate coordinate) {
        Coordinate around;
        ArrayList<Coordinate> list = new ArrayList<>();
        for (int x = coordinate.x - 1; x <= coordinate.x + 1; x++) {
            for (int y = coordinate.y - 1; y <= coordinate.y + 1; y++) {
                if (inRange(around = new Coordinate(x, y))) {
                    if (!around.equals(coordinate)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }
}
