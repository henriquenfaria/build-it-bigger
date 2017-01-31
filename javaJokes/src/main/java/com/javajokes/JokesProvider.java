package com.javajokes;

public class JokesProvider {
    private static String[] mJokes =
            {" A plateau is the highest form of flattery.",
            "It's hard to explain puns to kleptomaniacs because they always take things literally.",
            "Time flies like an arrow, fruit flies like a banana.",
            "A soldier survived mustard gas in battle, and then pepper spray by the police. He's now a seasoned veteran.",
            "What's the best thing about Switzerland? I don't know, but their flag is a huge plus.",
            "I told my doctor that I broke my arm in two places. He told me to stop going to those places.",
            "I'm addicted to brake fluid, but I can stop whenever I want.",
            "How do you keep an idiot in suspense?",
            "It takes a lot of balls to golf like me.",
             "What do you call a magic dog? A Labracadabrador."};

    public static String getJoke() {
        int randomJoke =  (int)(Math.random() * mJokes.length - 1);
        return mJokes[randomJoke];
    }
}
