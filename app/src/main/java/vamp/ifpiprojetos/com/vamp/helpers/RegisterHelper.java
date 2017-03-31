package vamp.ifpiprojetos.com.vamp.helpers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Spinner;

import vamp.ifpiprojetos.com.vamp.forms.ReceiverRegisterActivity;
import vamp.ifpiprojetos.com.vamp.forms.DonorRegisterActivity;
import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.forms.HospitalRegisterActivity;
import vamp.ifpiprojetos.com.vamp.models.Donor;
import vamp.ifpiprojetos.com.vamp.models.Hospital;
import vamp.ifpiprojetos.com.vamp.models.Receiver;

/**
 * Created by Jefferson Lima on 28/03/2017.
 */

public class RegisterHelper {

    private EditText nameField;
    private Spinner genreField;
    private EditText addressField;
    private EditText phoneField;
    private Spinner bloodTypeField;

    private Donor donor;
    private Hospital hospital;
    private Receiver receiver;

    public RegisterHelper(DonorRegisterActivity activity) {
        nameField = (EditText) activity.findViewById(R.id.donor_register_name);
        genreField = (Spinner) activity.findViewById(R.id.donor_register_genre);
        addressField = (EditText) activity.findViewById(R.id.donor_register_address);
        phoneField = (EditText) activity.findViewById(R.id.donor_register_phone);
        bloodTypeField = (Spinner) activity.findViewById(R.id.donor_register_bloodType);
        donor = new Donor();
    }

    public Donor getDonor() {
        donor.setBloodType(bloodTypeField.getSelectedItem().toString());
        donor.setGenre(genreField.getSelectedItem().toString());
        donor.setName(nameField.getText().toString());
        donor.setAddress(addressField.getText().toString());
        donor.setPhone(phoneField.getText().toString());
        return donor;
    }

    public RegisterHelper(HospitalRegisterActivity activity){
        nameField = (EditText) activity.findViewById(R.id.hospital_register_name);
        addressField = (EditText) activity.findViewById(R.id.hospital_register_address);
        phoneField = (EditText) activity.findViewById(R.id.hospital_register_phone);
        hospital = new Hospital();
    }

    public Hospital getHospital(){
        hospital.setName(nameField.getText().toString());
        hospital.setAddress(addressField.getText().toString());
        hospital.setPhone(phoneField.getText().toString());
        return hospital;
    }

    public RegisterHelper(ReceiverRegisterActivity activity) {
        nameField = (EditText) activity.findViewById(R.id.receiver_register_name);
        genreField = (Spinner) activity.findViewById(R.id.receiver_register_genre);
        addressField = (EditText) activity.findViewById(R.id.receiver_register_address);
        phoneField = (EditText) activity.findViewById(R.id.receiver_register_phone);
        bloodTypeField = (Spinner) activity.findViewById(R.id.receiver_register_bloodType);
        receiver = new Receiver();
    }

    public Receiver getReceiver(){
        receiver.setBloodType(bloodTypeField.getSelectedItem().toString());
        receiver.setGenre(genreField.getSelectedItem().toString());
        receiver.setName(nameField.getText().toString());
        receiver.setAddress(addressField.getText().toString());
        receiver.setPhone(phoneField.getText().toString());
        return receiver;
    }

    public void donorEdit(Donor donor) {
        nameField.setText(donor.getName());
        addressField.setText(donor.getAddress());
        phoneField.setText(donor.getPhone());
        this.donor = donor;
    }



}
