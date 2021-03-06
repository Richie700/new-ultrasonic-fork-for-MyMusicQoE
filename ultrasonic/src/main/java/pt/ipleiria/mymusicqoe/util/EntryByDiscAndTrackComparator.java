package pt.ipleiria.mymusicqoe.util;

import org.moire.ultrasonic.domain.MusicDirectory;

import java.io.Serializable;
import java.util.Comparator;

public class EntryByDiscAndTrackComparator implements Comparator<MusicDirectory.Entry>, Serializable
{
	private static final long serialVersionUID = 5540441864560835223L;

	@Override
	public int compare(MusicDirectory.Entry x, MusicDirectory.Entry y)
	{
		Integer discX = x.getDiscNumber();
		Integer discY = y.getDiscNumber();
		Integer trackX = x.getTrack();
		Integer trackY = y.getTrack();
		String albumX = x.getAlbum();
		String albumY = y.getAlbum();

		int albumComparison = compare(albumX, albumY);

		if (albumComparison != 0)
		{
			return albumComparison;
		}

		int discComparison = compare(discX == null ? 0 : discX, discY == null ? 0 : discY);

		if (discComparison != 0)
		{
			return discComparison;
		}

		return compare(trackX == null ? 0 : trackX, trackY == null ? 0 : trackY);
	}

	private static int compare(long a, long b)
	{
		return a < b ? -1 : a > b ? 1 : 0;
	}

	private static int compare(String a, String b)
	{
		if (a == null && b == null)
		{
			return 0;
		}

		if (a == null)
		{
			return -1;
		}

		if (b == null)
		{
			return 1;
		}

		return a.compareTo(b);
	}
}