package LLD.DesignPattern.CompositePattern;


/*
Problem: Design a UI Framework
Design a UI library where every UI element can be treated uniformly.
Requirements

Create an interface UIComponent
Implement
Button
TextField
Checkbox
Create a Panel that can contain multiple UIComponents (including another Panel).

Operations
render()
resize(width, height)
enable()
disable()

Expected Output:

Main Panel
    Login Panel
        Username TextField
        Password TextField
        Login Button
    Footer Panel
        Terms Checkbox

 */

import java.util.ArrayList;
import java.util.List;

public class UIFrameworkComposite {
    public static void main(String[] args) {
//        Panel mainPanel = new Panel("Main ");
//        Panel loginPanel = new Panel("Login ");
//        Panel footerPanel = new Panel("Footer ");
//
//        loginPanel.add(new TextField("Username "));
//        loginPanel.add(new TextField("Password "));
//        loginPanel.add(new Button("Login "));
//
//        footerPanel.add(new Checkbox("Terms "));
//
//        mainPanel.add(loginPanel);
//        mainPanel.add(footerPanel);
//
//
//        mainPanel.render();

        // By using Builder pattern

        Panel loginPanel = new PanelBuilder("Login ")
                .addTextField("Username ")
                .addTextField("Password ")
                .addButton("Login ")
                .build();

        Panel footerPanel = new PanelBuilder("Footer ")
                .addCheckBox("Terms ")
                .build();

        Panel mainPanel = new PanelBuilder("Main ")
                .addPanel(loginPanel)
                .addPanel(footerPanel)
                .build();

        mainPanel.render();
    }
}


interface UIComponent {
    void render();

    void resize(int width, int height);

    void enable();

    void disable();
}

class Button implements UIComponent {
    private final String name;

    Button(String name){
        this.name = name;
    }

    @Override
    public void render() {
        System.out.println(name + "Button");
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("Button resize" + width * height);
    }

    @Override
    public void enable() {
        System.out.println("Button enable");
    }

    @Override
    public void disable() {
        System.out.println("Button disable");
    }
}


class TextField implements UIComponent {

    private final String name;

    TextField(String name){
        this.name = name;
    }

    @Override
    public void render() {
        System.out.println(name + "TextField");
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("TextField resize" + width * height);
    }

    @Override
    public void enable() {
        System.out.println("TextField enable");
    }

    @Override
    public void disable() {
        System.out.println("TextField disable");
    }
}


class Checkbox implements UIComponent {

    private final String name;

    Checkbox(String name){
        this.name = name;
    }

    @Override
    public void render() {
        System.out.println(name + "Checkbox");
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("Checkbox resize" + width * height);
    }

    @Override
    public void enable() {
        System.out.println("Checkbox enable");
    }

    @Override
    public void disable() {
        System.out.println("Checkbox disable");
    }
}


class Panel implements UIComponent {
    // has a relationalship
    List<UIComponent> panels = new ArrayList<>();

    private final String name;

    Panel(String name){
        this.name = name;
    }

    public void add(UIComponent uiComponent){
        panels.add(uiComponent);
    }


    @Override
    public void render() {
        //Not printing the hierarchy wise
//        System.out.println(name + "Panel");
//        for(UIComponent panel:panels){
//            panel.render();
//        }
        render(0);
    }

    private void render(int level){
        System.out.println(indent(level) + name + " Panel");
        for(UIComponent component:panels){
            if(component instanceof Panel)
                ((Panel) component).render(level + 1);
            else {
                //print the space first
                System.out.print(indent(level + 1));
                component.render();
            }
        }
    }

    private String indent(int level) {
        return "    ".repeat(level);
    }

    @Override
    public void resize(int width, int height) {
        for(UIComponent panel:panels){
            panel.resize(width,height);
        }
    }

    @Override
    public void enable() {
        for(UIComponent panel:panels){
            panel.enable();
        }
    }

    @Override
    public void disable() {
        for(UIComponent panel:panels){
            panel.disable();
        }
    }
}


class PanelBuilder{
    private final Panel panel;

    PanelBuilder(String name){
        this.panel = new Panel(name);
    }

    PanelBuilder addTextField(String name){
        this.panel.add(new TextField(name));
        return this;
    }

    PanelBuilder addButton(String name){
        this.panel.add(new Button(name));
        return this;
    }

    PanelBuilder addCheckBox(String name){
        this.panel.add(new Checkbox(name));
        return this;
    }

    PanelBuilder addPanel(Panel newPanel){
        this.panel.add(newPanel);
        return this;
    }

    public Panel build(){
        return panel;
    }
}