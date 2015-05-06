package com.TRAXter.persistance.turtle.mapping;

import android.database.Cursor;
import com.TRAXter.model.*;
import com.TRAXter.persistance.framework.creator.ResultCreator;
import com.TRAXter.persistance.turtle.db.structure.Tables;

/**
 * TURTLE PLAYER
 * <p/>
 * Licensed under MIT & GPL
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 * <p/>
 * More Information @ www.turtle-player.co.uk
 *
 * @author Simon Honegger (Hoene84)
 */

public class TrackCreator implements ResultCreator<Tables.Tracks, Track, Cursor>
{
	public Track create(Cursor cursor)
	{
		return new Track(
				  new SongDigest(cursor.getString(cursor.getColumnIndex(Tables.SongsReadable.TITLE.getName()))),
				  new ArtistDigest(cursor.getString(cursor.getColumnIndex(Tables.ArtistsReadable.ARTIST.getName()))),
				  new AlbumDigest(cursor.getString(cursor.getColumnIndex(Tables.AlbumsReadable.ALBUM.getName()))),
				  new GenreDigest(cursor.getString(cursor.getColumnIndex(Tables.GenresReadable.GENRE.getName()))),
				  cursor.getInt(cursor.getColumnIndex(Tables.Tracks.NUMBER.getName())),
				  cursor.getString(cursor.getColumnIndex(Tables.FsObjects.PATH.getName())),
				  cursor.getString(cursor.getColumnIndex(Tables.FsObjects.NAME.getName()))
		);
	}
}
