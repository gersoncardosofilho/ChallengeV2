package gersondeveloper.com.br.challengev2.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gersondeveloper.com.br.challengev2.Adapter.ComprasAdapter;
import gersondeveloper.com.br.challengev2.Model.Transaction;
import gersondeveloper.com.br.challengev2.Model.User;
import gersondeveloper.com.br.challengev2.R;
import gersondeveloper.com.br.challengev2.Util.ChallengeUtil;

/**
 * Created by gerso on 13/10/2016.
 */

public class FragmentCompras extends Fragment {

    public static final String FRAG_ID = "fragment_opcoes";
    public static final String TAG = FragmentOpcoes.class.getName();
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    FragmentActivity activity;


    private TextView idPaymentTextView, productValueTextView, productNameTextView;
    private ImageView productImageView;
    private Button cancelaTransactionButton;

    private String username;

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compras, container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_compras);
        gridLayoutManager = new GridLayoutManager(activity,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        User user = new User();
        user = ChallengeUtil.getUser(activity);
        username = user.getUsername();
        //transactions = getTransactions(user);

        recyclerView.setAdapter(new ComprasAdapter(activity, transactions));

        return view;
    }

    /*private ArrayList<Transaction> getTransactions(User user)
    {
       try
        {
            DatabaseHelper databaseHelper = new DatabaseHelper(activity);
            Dao<Transaction, Integer> transactionDao = null;

            try
            {
                transactionDao = databaseHelper.getTransactionDAO();
            }catch(SQLException ex){
                ex.printStackTrace();
            }

            final ArrayList<Transaction> transactionsList = new ArrayList<Transaction>();

            final QueryBuilder<Transaction, Integer> queryBuilder = transactionDao.queryBuilder();
            queryBuilder.where().eq(Transaction.USERNAME, user.getUsername());

            final PreparedQuery<Transaction> preparedQuery = queryBuilder.prepare();

            final Iterator<Transaction> transactionIterator = transactionDao.query(preparedQuery).iterator();

            while(transactionIterator.hasNext())
            {
                final Transaction transactionDetails = transactionIterator.next();
                transactionsList.add(transactionDetails);
            }

            return transactionsList;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }*/
    //}
}