package com.Reto2;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.Reto2.modelos.Estudiantes;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Notificaciones {

    private static final String EMAIL_REMITENTE = "tuexample@gmail.com"; 
    private static final String PASSWORD_REMITENTE = "xxxxxxxxxxxxxxxxxx";   // tu clave de aplicacion en gmail
    private static final String SMTP_HOST = "smtp.gmail.com";          
    private static final String SMTP_PORT = "587";                     
    private static final String SMTP_AUTH = "true";
    private static final String SMTP_STARTTLS_ENABLE = "true";

    public static void notificarSuspensionMalaga(
            List<Estudiantes> listaMatematicas,
            List<Estudiantes> listaFrances,
            List<Estudiantes> listaAmbas) {

        Set<Estudiantes> notificados = new HashSet<>();

        // Configuración de las propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", SMTP_AUTH);
        props.put("mail.smtp.starttls.enable", SMTP_STARTTLS_ENABLE);

        // Crear sesión de correo con autenticación
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_REMITENTE, PASSWORD_REMITENTE);
            }
        });

        try {
            // 1. Identificamos estudiantes de Matemáticas (solo Málaga) y enviamos correo.
            Set<Estudiantes> matematicasSoloMalaga = new HashSet<>();
            for (Estudiantes estudiante : listaMatematicas) {
                if (estudiante.sede.equalsIgnoreCase("Málaga") && !estaEnLista(estudiante, listaFrances)) {
                    matematicasSoloMalaga.add(estudiante);
                    enviarCorreo(session, estudiante.email,
                            "Suspensión de Clases de Matemáticas - Sede Málaga",
                            "Estimado/a estudiante,\n\nLe informamos que las clases de Matemáticas programadas para mañana en la sede de Málaga han sido suspendidas debido a una incidencia.\n\nDisculpe las molestias.");
                    notificados.add(estudiante);
                }
            }

            // 2. Estudiantes de Francés (solo Málaga) y enviamos correo.
            Set<Estudiantes> francesSoloMalaga = new HashSet<>();
            for (Estudiantes estudiante : listaFrances) {
                if (estudiante.sede.equalsIgnoreCase("Málaga") && !estaEnLista(estudiante, listaMatematicas)) {
                    if (!notificados.contains(estudiante)) {
                        enviarCorreo(session, estudiante.email,
                                "Suspensión de Clases de Francés - Sede Málaga",
                                "Estimado/a estudiante,\n\nLe informamos que las clases de Francés programadas para mañana en la sede de Málaga han sido suspendidas debido a una incidencia.\n\nDisculpe las molestias.");
                        notificados.add(estudiante);
                    }
                }
            }

            // 3. Estudiantes de Matemáticas y Francés (Málaga) y enviamos correo.
            Set<Estudiantes> ambasMalaga = new HashSet<>();
            for (Estudiantes estudiante : listaAmbas) {
                if (estudiante.sede.equalsIgnoreCase("Málaga")) {
                    if (!notificados.contains(estudiante)) {
                        enviarCorreo(session, estudiante.email,
                                "Suspensión de Clases de Matemáticas y Francés - Sede Málaga",
                                "Estimado/a estudiante,\n\nLe informamos que las clases de Matemáticas y Francés programadas para mañana en la sede de Málaga han sido suspendidas debido a una incidencia.\n\nDisculpe las molestias.");
                        notificados.add(estudiante);
                    }
                }
            }

        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean estaEnLista(Estudiantes estudiante, List<Estudiantes> lista) {
        for (Estudiantes e : lista) {
            if (estudiante.equals(e)) {
                return true;
            }
        }
        return false;
    }

    private static void enviarCorreo(Session session, String destinatarioEmail, String asunto, String cuerpo) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_REMITENTE));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatarioEmail));
        message.setSubject(asunto);
        message.setText(cuerpo);

        Transport.send(message);
        System.out.println("Correo enviado a: " + destinatarioEmail);
    }
    
                                                          // debes agregar los correos destinatarios
    public static void main(String[] args) {        
        List<Estudiantes> matematicas = List.of(
                new Estudiantes("Maria Gomez", "Málaga", "tuexample@gmail.com"),   
                new Estudiantes("Pedro Gonzalez", "Sevilla", "tuexample@gmail.com"),
                new Estudiantes("Luis Martinez", "Málaga", "tuexample@gmail.com"),
                new Estudiantes("Sofia Soto", "Málaga", "tuexample@gmail.com")
        );

        List<Estudiantes> frances = List.of(
                new Estudiantes("Aura Escalona", "Málaga", "tuexample@gmail.com"),
                new Estudiantes("Arturo Díaz", "Granada", "tuexample@gmail.com"),
                new Estudiantes("Richard Paez", "Málaga", "tuexample@gmail.com"),
                new Estudiantes("Alejandro Torres", "Málaga", "tuexample@gmail.com")
        );

        List<Estudiantes> ambas = List.of(
                new Estudiantes("Giojana Rojas", "Málaga", "tuexample@gmail.com"),
                new Estudiantes("Karolina hernandez", "Málaga", "tuexample@gmail.com")
        );

        notificarSuspensionMalaga(matematicas, frances, ambas);
    }
}
