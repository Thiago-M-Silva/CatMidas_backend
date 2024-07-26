package com.example.catalogo.services;

import com.example.catalogo.Model.Audio.*;
import com.example.catalogo.Model.Desenho.*;
import com.example.catalogo.Model.Filme.*;
import com.example.catalogo.Model.Jogos.*;
import com.example.catalogo.Model.Livro.*;
import com.example.catalogo.Model.Novela.*;
import com.example.catalogo.Model.Quadrinho.*;
import com.example.catalogo.Model.Serie.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DesenhoRepository desenhoRep;

    @Autowired
    private AudioRepository audioRep;

    @Autowired
    private FilmeRepository filmeRep;

    @Autowired
    private JogosRepository jogosRep;

    @Autowired
    private LivroRepository livroRep;

    @Autowired
    private NovelaRepository novelaRep;

    @Autowired
    private QuadrinhoRepository quadrinhoRep;

    @Autowired
    private SerieRepository serieRep;

    public byte[] gerarPdfAudio(List<AudioResponseDTO> audioList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (AudioResponseDTO audio : audioList) {
                document.add(new Paragraph(audio.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }

    public byte[] gerarPdfDesenho(List<DesenhoResponseDTO> desenhoList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (DesenhoResponseDTO desenho : desenhoList) {
                document.add(new Paragraph(desenho.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }

    public byte[] gerarPdfFilme(List<FilmeResponseDTO> FilmeList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (FilmeResponseDTO Filme : FilmeList) {
                document.add(new Paragraph(Filme.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }

    public byte[] gerarPdfJogos(List<JogosResponseDTO> JogosList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (JogosResponseDTO Jogos : JogosList) {
                document.add(new Paragraph(Jogos.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }

    public byte[] gerarPdfLivro(List<LivroResponseDTO> LivroList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (LivroResponseDTO Livro : LivroList) {
                document.add(new Paragraph(Livro.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }

    public byte[] gerarPdfNovela(List<NovelaResponseDTO> NovelaList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (NovelaResponseDTO Novela : NovelaList) {
                document.add(new Paragraph(Novela.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }

    public byte[] gerarPdfQuadrinho(List<QuadrinhoResponseDTO> QuadrinhoList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (QuadrinhoResponseDTO Quadrinho : QuadrinhoList) {
                document.add(new Paragraph(Quadrinho.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }
    public byte[] gerarPdfSerie(List<SerieResponseDTO> SerieList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            for (SerieResponseDTO Serie : SerieList) {
                document.add(new Paragraph(Serie.toString()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out.toByteArray();
    }
}