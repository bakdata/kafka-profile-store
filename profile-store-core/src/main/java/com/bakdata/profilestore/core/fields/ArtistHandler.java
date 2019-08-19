package com.bakdata.profilestore.core.fields;

import com.bakdata.profilestore.common.avro.ListeningEvent;
import com.bakdata.profilestore.core.FieldType;
import com.bakdata.profilestore.core.avro.ChartRecord;
import com.bakdata.profilestore.core.avro.UserProfile;
import java.util.List;

public class ArtistHandler implements FieldHandler {

    @Override
    public long extractId(final ListeningEvent listeningEvent) {
        return listeningEvent.getArtistId();
    }

    @Override
    public UserProfile updateProfile(final UserProfile userProfile, final List<ChartRecord> charts) {
        userProfile.setTopTenArtist(charts);
        return userProfile;
    }

    @Override
    public List<ChartRecord> getCharts(final UserProfile userProfile) {
        return userProfile.getTopTenArtist();
    }

    @Override
    public FieldType type() {
        return FieldType.ARTIST;
    }
}
