import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ContratoService {

    public void gerarContrato() throws Exception {
        try (InputStream is = getClass().getResourceAsStream("/templates/contrato_modelo.docx")) {
            if (is == null) {
                throw new IllegalStateException("Modelo de contrato não encontrado!");
            }

            XWPFDocument document = new XWPFDocument(is);

            // aqui entra a lógica de substituição dos campos...
        }
    }
}

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GerarContratoPOI {
    public static void main(String[] args) throws IOException {
        // 1. Abre o contrato modelo
        FileInputStream fis = new FileInputStream("contrato_modelo.docx");
        XWPFDocument document = new XWPFDocument(fis);

        // 2. Substitui texto nos parágrafos
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            for (XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0);
                if (text != null) {
                    text = text.replace("${nome_cliente}", "Douglas Marques")
                               .replace("${cpf_cliente}", "123.456.789-00")
                               .replace("${data_contrato}", "06/08/2025")
                               .replace("${valor_contrato}", "R$ 15.000,00");
                    run.setText(text, 0);
                }
            }
        }

        // 3. Substitui texto nas tabelas (se tiver)
        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        for (XWPFRun run : paragraph.getRuns()) {
                            String text = run.getText(0);
                            if (text != null) {
                                text = text.replace("${nome_cliente}", "Douglas Marques")
                                           .replace("${cpf_cliente}", "123.456.789-00")
                                           .replace("${data_contrato}", "06/08/2025")
                                           .replace("${valor_contrato}", "R$ 15.000,00");
                                run.setText(text, 0);
                            }
                        }
                    }
                }
            }
        }

        // 4. Salva o contrato preenchido
        FileOutputStream fos = new FileOutputStream("contrato_preenchido.docx");
        document.write(fos);
        fos.close();
        document.close();
        fis.close();

        System.out.println("Contrato gerado com sucesso!");
    }
}

