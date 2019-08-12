package com.bakdata.profilestore.core.fields;

import com.bakdata.profilestore.common.avro.ListeningEvent;
import com.bakdata.profilestore.common.FieldType;
import com.bakdata.profilestore.core.avro.ChartTuple;
import com.bakdata.profilestore.core.avro.UserProfile;
import java.util.List;

public class TrackHandler extends FieldHandler {

    public TrackHandler() {
        super(FieldType.TRACK);
    }

    @Override
    public long extractId(final ListeningEvent listeningEvent) {
        return listeningEvent.getTrackId();
    }

    @Override
    public UserProfile updateProfile(final UserProfile userProfile, final List<ChartTuple> charts) {
        userProfile.setTopTenTracks(charts);
        return userProfile;
    }


    @Override
    public FieldType type() {
        return FieldType.TRACK;
    }
}