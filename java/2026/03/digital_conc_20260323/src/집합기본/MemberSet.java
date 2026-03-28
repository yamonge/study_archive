package 집합기본;

public class MemberSet {
    int id;
    String name;

    public MemberSet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "MemberSet [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  MemberSet){
           MemberSet member = (MemberSet) obj;
           return this.id == member.id && this.name.equals(member.name);
        }else{
            return false;
        }
    }
}
