package org.rul.nutrimake;

/*import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.configuration.db.util.DatabaseInitializer;
import org.rul.nutrimake.model.Cliente;

import java.util.List;
import java.util.Locale;

public class OldMainActivity extends LifecycleActivity {

    private AppDatabase mDb;

    private TextView misClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        misClientes = (TextView) findViewById(R.id.young_users_tv);

        // Note: Db references should not be in an activity.
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

        fetchData();
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void populateDb() {
        DatabaseInitializer.populateSync(mDb);
    }

    private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        List<Cliente> clientes = mDb.getClienteDao().findYoungerThanSolution(35);
        for (Cliente cliente : clientes) {
            sb.append(String.format(Locale.US,
                    "%s, %s (%d)\n", cliente.apellidos, cliente.nombre, cliente.edad));
        }
        misClientes.setText(sb);
    }
}
*/