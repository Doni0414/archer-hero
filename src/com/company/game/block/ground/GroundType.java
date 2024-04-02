package com.company.game.block.ground;

public enum GroundType {
    TYPE1("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type1.png"),
    TYPE2("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type2.png"),
    TYPE3("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type3.png"),
    TYPE4("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type4.png"),
    TYPE5("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type5.png"),
    TYPE6("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type6.png"),
    TYPE7("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type7.png"),
    TYPE8("C:\\Users\\сулпак\\IdeaProjects\\JavaEduProject\\JavaStart\\Lesson 4. Arrays, Multi-Dimensional Arrays\\Lectures\\Archer Game\\resources\\sprites\\blocks\\grounds\\type8.png");

    private String path;

    GroundType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
