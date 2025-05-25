package com.example.teste_menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {

    private final List<Integer> imagens;

    public CarouselAdapter(List<Integer> imagens) {
        this.imagens = imagens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carousel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.imageView.setImageResource(imagens.get(position));
            // Configurações adicionais recomendadas:
            holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.imageView.setAdjustViewBounds(true);
        } catch (Exception e) {
            e.printStackTrace();
            // Fallback para imagem padrão em caso de erro
            holder.imageView.setImageResource(R.drawable.ic_image_placeholder);
        }
    }

    @Override
    public int getItemCount() {
        return imagens != null ? imagens.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            // Garanta que o ImageView existe no layout:
            if (imageView == null) {
                throw new IllegalStateException("ImageView não encontrado no layout item_carousel");
            }
        }
    }
}