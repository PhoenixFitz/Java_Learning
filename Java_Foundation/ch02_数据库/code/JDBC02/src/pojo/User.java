package pojo;


public class User {
    private int unum;
    private String uname;
    private String upwd;
    public int getUnum() {
        return unum;
    }
    public void setUnum(int unum) {
        this.unum = unum;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
    @Override
    public String toString() {
        return "User [unum=" + unum + ", uname=" + uname + ", upwd=" + upwd + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uname == null) ? 0 : uname.hashCode());
        result = prime * result + unum;
        result = prime * result + ((upwd == null) ? 0 : upwd.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (uname == null) {
            if (other.uname != null)
                return false;
        } else if (!uname.equals(other.uname))
            return false;
        if (unum != other.unum)
            return false;
        if (upwd == null) {
            if (other.upwd != null)
                return false;
        } else if (!upwd.equals(other.upwd))
            return false;
        return true;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(int unum, String uname, String upwd) {
        super();
        this.unum = unum;
        this.uname = uname;
        this.upwd = upwd;
    }




}
