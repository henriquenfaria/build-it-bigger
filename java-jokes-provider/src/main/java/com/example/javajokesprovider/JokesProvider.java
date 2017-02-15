package com.example.javajokesprovider;

public class JokesProvider {
    private static String[] mJokes =
            { "A plateau is the highest form of flattery.",
            "It's hard to explain puns to kleptomaniacs because they always take things literally.",
            "Time flies like an arrow, fruit flies like a banana.",
            "A soldier survived mustard gas in battle, and then pepper spray by the police. He's now a seasoned veteran.",
            "What's the best thing about Switzerland? I don't know, but their flag is a huge plus.",
            "I told my doctor that I broke my arm in two places. He told me to stop going to those places.",
            "I'm addicted to brake fluid, but I can stop whenever I want.",
            "How do you keep an idiot in suspense?",
            "It takes a lot of balls to golf like me.",
            "What do you call a magic dog? A Labracadabrador.",
            "The dyslexic devil worshipper sold his soul to Santa.",
            "You kill vegetarian vampires with a steak to the heart.",
            "If you want to catch a squirrel just climb a tree and act like a nut.",
            "Did you hear about the Mexican train killer? He had locomotives.",
            "What kind of shoes do ninjas wear? Sneakers.",
            "How does NASA organize their company parties? They planet.",
            "What do you call dangerous precipitation? A rain of terror.",
            "What do you call a big pile of kittens? A meowntain.",
            "Just went to an emotional wedding. Even the cake was in tiers.",
            "What do you call a dinosaur with a extensive vocabulary? A thesaurus.",
            "How did the hipster burn his tongue? He drank his coffee before it was cool.",
            "Dry erase boards are remarkable.",
            "How do you make Holy water? Boil the hell out of it." };

    public static String getJoke() {
        int randomJoke =  (int)(Math.random() * mJokes.length - 1);
        return mJokes[randomJoke];
    }
}
