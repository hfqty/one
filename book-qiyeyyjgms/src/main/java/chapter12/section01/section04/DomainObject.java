package chapter12.section01.section04;

public class DomainObject {

    public  long PLACEHOLDER_ID = -1;
    public long Id= PLACEHOLDER_ID;
    public boolean isNew(){
        return Id == PLACEHOLDER_ID;
    }
}
