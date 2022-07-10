package com.cos.blogv2.domain.management.repository;

public class Queries {
    //#{#entityName}은 repository 인터페이스 정의 할때 <엔티티 타입, pk 타입>에서
    //엔티티 타입을 자동으로 참고 한다.
    public static final String DELETE_BY_ID = """
            UPDATE
                #{#entityName}
            SET
                deleted_at = CURRENT_TIMESTAMP
            WHERE id = ?1
        """;

    public static final String DELETE_ALL = """
            UPDATE
                #{#entityName}
            SET
                deleted_at = CURRENT_TIMESTAMP
            """;

    public static final String NON_DELETED_CLAUSE = "deleted_at IS NULL";
}
