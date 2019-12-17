package org.cleancode.journal.service;

import org.cleancode.journal.domain.Progress;

import java.io.Serializable;

public interface IProgressService extends Serializable {
    Progress getCurrentProgress();
}
