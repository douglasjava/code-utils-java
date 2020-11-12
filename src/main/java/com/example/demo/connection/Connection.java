package com.example.demo.connection;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connection {

    Session session;
    ChannelSftp sftp;

}
