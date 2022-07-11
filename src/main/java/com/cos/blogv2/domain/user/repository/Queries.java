package com.cos.blogv2.domain.user.repository;

public class Queries {
    public static final String DELETE_USER_BY_ID = """
        UPDATE
            #{#entityName}
        SET
            deleted_email = (
                SELECT
                    email
                FROM
                    #{#entityName}
                WHERE id = ?1),
            email = NULL,
            deleted_at = CURRENT_TIMESTAMP,
            active = false,
            deleted_by = ?#{principal?.id}
        WHERE id = ?1
    """;

    public static final String COUNT_ENABLED_USER = """
        SELECT
            count(id)
        FROM
            "user"
        WHERE deleted_at is null
    """;

    public static final String FIND_ALL_USER_FETCH_ROLES = """
        with user_roles as (
            select
                ur.user_id, string_agg(r.initials, ',') roles
            from "role" r
                left join user_role ur on r.id = ur.role_id
            group by ur.user_id
        )
        
        select
            u.id,
            u."name",
            u.email,
            u.password,
            urs.roles
        from
            "user" u
        left join user_roles as urs on urs.user_id = u.id
        where u.deleted_at is null
        order by u.created_at desc
    """;

    public static final String FIND_BY_FIELD_FETCH_ROLES = """
        with user_roles as (
            select
                    ur.user_id, string_agg(r.initials, ',') roles
            from "role" r
                    left join user_role ur on r.id = ur.role_id
            group by ur.user_id
        )

        select
            u.id,
            u."name",
            u.email,
            u.password,
            urs.roles
        from
            "user" u
        left join user_roles as urs on urs.user_id = u.id
        where u.deleted_at is null and %s
        order by u.created_at desc
    """;
}
