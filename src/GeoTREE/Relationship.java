package GeoTREE;

public enum Relationship {
    parent {
        public Relationship getOppositeRelationship() {
            return children;
        }
    },
    children {
        public Relationship getOppositeRelationship() {
            return parent;
        }
    },
    Sibling {
        public Relationship getOppositeRelationship() {
            return Sibling;
        }
    },
    Spouse {
        public Relationship getOppositeRelationship() {
            return Spouse;
        }
    },
    Grandparent {
        public Relationship getOppositeRelationship() {
            return Grandchild;
        }
    },
    Grandchild {
        public Relationship getOppositeRelationship() {
            return Grandparent;
        }
    },
    Aunt_Uncle {
        public Relationship getOppositeRelationship() {
            return NEPHEW_NIECE;
        }
    },
    NEPHEW_NIECE {
        public Relationship getOppositeRelationship() {
            return Aunt_Uncle;
        }
    },
    UNKNOWN {
        public Relationship getOppositeRelationship() {
            return UNKNOWN;
        }
    },
    Cousin {
        public Relationship getOppositeRelationship() {
            return Cousin;
        }
    };

    public abstract Relationship getOppositeRelationship();
}