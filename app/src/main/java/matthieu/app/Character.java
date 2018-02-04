package matthieu.app;

/**
 * Created by Matthieu on 25/01/2018.
 */

public class Character {
    private int img;
    private String pseudo;
    private String text;
    private String desc;

    public Character(int img, String pseudo, String text, String desc) {
        this.img = img;
        this.pseudo = pseudo;
        this.text = text;
        this.desc = desc;
    }


    public int getImage() {return img; }

    public void setImage(int img) {
        this.img = img;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
