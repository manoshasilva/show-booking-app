package jpmc.book.rows;

import jpmc.book.interpreter.command.Command;
import jpmc.book.interpreter.command.enums.CommandType;

import java.util.HashMap;
import java.util.Map;

public enum Rows {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8),
    I(9),
    J(10),
    K(11),
    L(12),
    M(13),
    N(14),
    O(15),
    P(16),
    Q(17),
    R(18),
    S(19),
    T(20),
    U(21),
    V(22),
    W(23),
    X(24),
    Y(25),
    Z(26);

    private static final Map<Integer, String> BY_ROW_ID = new HashMap<>();

    static {
        for(Rows rows : values()) {
            BY_ROW_ID.put(rows.rowId, rows.name());
        }
    }

    private Integer rowId;

    Rows(Integer rowId) {
        this.rowId = rowId;
    }

    public Integer getRowId() {
        return rowId;
    }

    public static String getRowById(Integer rowId) {
        return BY_ROW_ID.get(rowId);
    }
}
