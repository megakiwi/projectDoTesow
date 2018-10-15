package pl.testy;

public class GamePlay {

    public static String play(int number){
        if(0 == number )
            throw new IllegalArgumentException("Number must not be 0");
        if(number % 3 == 0)
        return "ok";
        if(number % 3 != 0)
            return "smuteczek";
        return String.valueOf(number);
    }
}
