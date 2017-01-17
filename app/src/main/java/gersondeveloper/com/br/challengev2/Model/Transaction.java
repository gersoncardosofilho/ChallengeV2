package gersondeveloper.com.br.challengev2.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by gerso on 09/10/2016.
 */

@DatabaseTable
public class Transaction extends RealmObject implements Parcelable {

    private static final long serialVersionUID = -222864131214757024L;

    public static final String ID_TRANSACTION = "id_transaction";
    public static final String USERNAME = "username";
    public static final String ID_PAYMENT = "id_payment";

    @PrimaryKey
    public int idTransaction;


    public String username;


    public String email;


    public String productName;

    public String idPayment;

    public Double productValue;

    public int productImage;


    public int getProdutImage() {
        return productImage;
    }

    public void setProdutImage(int produtImage) {
        this.productImage = produtImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(String idPayment) {
        this.idPayment = idPayment;
    }

    public Double getProductValue() {
        return productValue;
    }

    public void setProductValue(Double productValue) {
        this.productValue = productValue;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    //Constructor
    public Transaction()
    {

    }

    public Transaction(String username, String email, String productName, String idPayment, double productValue, int productImage)
    {
        this.username = username;
        this.email = email;
        this.productName = productName;
        this.idPayment = idPayment;
        this.productValue = productValue;
        this.productImage = productImage;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(email);
        parcel.writeString(productName);
        parcel.writeString(idPayment);
        parcel.writeDouble(productValue);
        parcel.writeInt(productImage);
    }

    //constructor for createFromParcel
    public Transaction(Parcel in)
    {
        this.username = in.readString();
        this.email = in.readString();
        this.productName = in.readString();
        this.idPayment = in.readString();
        this.productValue = in.readDouble();
        this.productImage = in.readInt();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {

        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
