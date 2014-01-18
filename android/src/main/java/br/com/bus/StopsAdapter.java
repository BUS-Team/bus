package br.com.bus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.bus.model.Stop;

public class StopsAdapter extends ArrayAdapter<Stop> {

    public StopsAdapter(Context context, List<Stop> stops) {
        super(context, R.layout.support_simple_spinner_dropdown_item, stops);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    public View initView(int position, View convertView, ViewGroup parent) {
        Stop stop = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, null);
        }

        TextView tvStopName = (TextView) convertView.findViewById(android.R.id.text1);
        tvStopName.setText(stop.getName());

        return convertView;
    }
}
