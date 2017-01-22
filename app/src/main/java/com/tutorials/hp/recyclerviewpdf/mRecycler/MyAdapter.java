package com.tutorials.hp.recyclerviewpdf.mRecycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorials.hp.recyclerviewpdf.PDFActivity;
import com.tutorials.hp.recyclerviewpdf.R;
import com.tutorials.hp.recyclerviewpdf.mPDF.PDFDoc;

import java.util.ArrayList;

/**
 * Created by Oclemy on 8/6/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<PDFDoc> pdfDocs;

    public MyAdapter(Context c, ArrayList<PDFDoc> pdfDocs) {
        this.c = c;
        this.pdfDocs = pdfDocs;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final PDFDoc pdfDoc=pdfDocs.get(position);

        holder.nameTxt.setText(pdfDoc.getName());
        holder.img.setImageResource(R.drawable.pdf_icon);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openPDFView(pdfDoc.getPath());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pdfDocs.size();
    }

    //OPEN PDF VIEW
    private void openPDFView(String path)
    {
        Intent i=new Intent(c,PDFActivity.class);
        i.putExtra("PATH",path);
        c.startActivity(i);
    }
}
