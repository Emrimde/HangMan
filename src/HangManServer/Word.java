
package HangManServer;

public class Word {
    private String word;
    private boolean isSelected;
    
    public Word(String word){
        this.word = word;
        isSelected = false;
    }

    public String getWord() {
        return word;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    
}
