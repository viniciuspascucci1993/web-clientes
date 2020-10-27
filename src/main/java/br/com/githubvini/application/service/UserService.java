package br.com.githubvini.application.service;

import br.com.githubvini.application.model.entities.Usuario;
import br.com.githubvini.application.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementação de user detail service.
 * @author Vinicius Torres Pascucci.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername( String cpf ) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                        .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado.") );


        return User
                .builder()
                .username(usuario.getCpf())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
