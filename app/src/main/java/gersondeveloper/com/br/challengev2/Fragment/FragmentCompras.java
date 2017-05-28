package gersondeveloper.com.br.challengev2.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import butterknife.BindView;
import butterknife.ButterKnife;
import gersondeveloper.com.br.challengev2.Adapter.TransactionAdapter;
import gersondeveloper.com.br.challengev2.Model.Transaction;
import gersondeveloper.com.br.challengev2.Model.User;
import gersondeveloper.com.br.challengev2.R;
import gersondeveloper.com.br.challengev2.Util.ChallengeUtil;
import io.realm.Realm;

/**
 * Created by gerso on 13/10/2016.
 */

public class FragmentCompras extends Fragment {

    public static final String FRAG_ID = "fragment_opcoes";
    public static final String TAG = FragmentOpcoes.class.getName();

    LinearLayoutManager linearLayoutManage;
    FragmentActivity activity;

    @BindView(R.id.rv_compras)
    RecyclerView recyclerView;

    private Realm realm;

    private String username;

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compras, container,false);
        ButterKnife.bind(this, view);

        linearLayoutManage = new LinearLayoutManager(activity, 1, false);
        recyclerView.setLayoutManager(linearLayoutManage);

        realm = Realm.getDefaultInstance();

        User user = new User();
        user = ChallengeUtil.getUser(activity);
        username = user.getUsername();

        //transactions = getTransactions();
        recyclerView.setAdapter(new TransactionAdapter(activity, transactions));
        return view;
    }

//   public ArrayList<Transaction> getTransactions()
//    {
//            ArrayList<Transaction> transactions = new ArrayList<>();
//
//
//            try {
//                transactionDAO = getHelper().getTransactionDAO();
//                final QueryBuilder<Transaction, Integer> queryBuilder = transactionDAO.queryBuilder();
//                queryBuilder.where().eq(Transaction.USERNAME, username);
//                final PreparedQuery<Transaction> preparedQuery = queryBuilder.prepare();
//                final Iterator<Transaction> transactionIterator = transactionDAO.query(preparedQuery).iterator();
//                while(transactionIterator.hasNext())
//                {
//                    final Transaction transaction1 = transactionIterator.next();
//                    transactions.add(transaction1);
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return transactions;
//        }



}
