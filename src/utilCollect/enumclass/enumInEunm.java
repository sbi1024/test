package utilCollect.enumclass;

public enum enumInEunm {
    STATUS_BOY("소년") {
        @Override
        public void soutComment() {
            System.out.println("getComment() = " + getComment());
        }
    },
    STATUS_GRAND_PATHER("할아버지") {
        @Override
        public void soutComment() {
            System.out.println("getComment() = " + getComment());
        }
    },
    STATUS_GIRL("소녀") {
        @Override
        public void soutComment() {
            System.out.println("getComment() = " + getComment());
        }
    },
    STATUS_GRAND_MOTHER("할머니") {
        @Override
        public void soutComment() {
            System.out.println("getComment() = " + getComment());
        }
    };

    String comment;

    enumInEunm(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public abstract void soutComment();
}
