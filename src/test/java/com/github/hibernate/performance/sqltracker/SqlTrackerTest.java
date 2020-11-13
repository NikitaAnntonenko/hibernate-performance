package com.github.hibernate.performance.sqltracker;

import com.github.hibernate.performance.BaseTest;
import com.github.hibernate.performance.sqltracker.entity.Account;
import com.github.hibernate.performance.sqltracker.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.github.hibernate.performance.sqltracker.AssertSqlCount.assertSelectCount;

@Sql("/sqltracker.sql")
public class SqlTrackerTest extends BaseTest {
    @Test
    public void showStatistics() {
        Client client = session.get(Client.class, 1);
    }

    @Test
    public void sqlCountAssertion() {
        Account account1 = session.get(Account.class, 1);
        Account account2 = session.get(Account.class, 2);

        assertSelectCount(2);
    }
}
