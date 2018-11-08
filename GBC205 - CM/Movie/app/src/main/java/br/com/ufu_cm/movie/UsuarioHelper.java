package br.com.ufu_cm.movie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;

public class UsuarioHelper
{
    private Usuario user;

    private ImageView foto;
    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtCpf;
    private EditText edtNasciemento;
    private EditText edtEmail;
    private EditText edtSenha;

    public UsuarioHelper(TelaCadastro tela)
    {
        foto = (ImageView) tela.findViewById(R.id.userImage);
        edtNome = (EditText) tela.findViewById(R.id.editCadastroNome);
        edtTelefone = (EditText) tela.findViewById(R.id.editCadastroTelefone);
        edtCpf = (EditText) tela.findViewById(R.id.editCadastroCPF);
        edtNasciemento = (EditText) tela.findViewById(R.id.editCadastroNascimento);
        edtEmail = (EditText) tela.findViewById(R.id.editCadastroEmail);
        edtSenha = (EditText) tela.findViewById(R.id.editCadastroSenha);

        user = new Usuario();
    }

    public Usuario getUsuario()
    {
        user.setNome(edtNome.getText().toString());
        user.setTelefone(edtTelefone.getText().toString());
        user.setCpf(edtCpf.getText().toString());
        user.setNascimento(edtNasciemento.getText().toString());
        user.setEmail(edtEmail.getText().toString());
        user.setSenha(edtSenha.getText().toString());

        return user;
    }

    public void setUsuario(Usuario user)
    {
        edtNome.setText(user.getNome());
        edtTelefone.setText(user.getTelefone());
        edtCpf.setText(user.getCpf());
        edtNasciemento.setText(user.getNascimento());
        edtEmail.setText(user.getEmail());
        edtSenha.setText(user.getSenha());
        this.user = user;

        if(user.getFoto() != null)
        {
            carregarFoto(user.getFoto());
        }
    }

    public ImageView getFoto(){
        return foto;
    }

    public void carregarFoto(String localFoto)
    {
        Bitmap imagemFoto = BitmapFactory.decodeFile(localFoto);
        Bitmap imagemFotoReduzida = Bitmap.createScaledBitmap(imagemFoto,130,130,true);
        user.setFoto(localFoto);
        foto.setImageBitmap(imagemFotoReduzida);
    }

}
